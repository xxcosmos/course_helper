package me.xiaoyuu.course_helper.util;

import com.alibaba.fastjson.JSONArray;
import me.xiaoyuu.course_helper.constant.SoapConstant;
import me.xiaoyuu.course_helper.dto.ChosenCourseDTO;
import me.xiaoyuu.course_helper.dto.GradeInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static me.xiaoyuu.course_helper.constant.SoapConstant.*;

public class SoapUtil {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);

    /**
     * 得到SOAP请求对象
     *
     * @param params 参数列表
     * @param method API
     * @return 请求对象
     * @throws SOAPException
     */
    private static SOAPMessage getSOAPRequest(List<String> params, String method) throws SOAPException {
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        //添加命名空间
        envelope.addNamespaceDeclaration("d", "http://www.w3.org/2001/XMLSchema");

        SOAPElement soapElement = envelope.getBody().addChildElement(method);
        soapElement.addNamespaceDeclaration("a", TARGET_NS);
        soapElement.setAttribute("id", "o0");
        soapElement.setAttributeNS("http://schemas.xmlsoap.org/soap/encoding/", "root", "1");
        //设置参数
        for (String s : params) {
            SOAPElement soapElement1 = soapElement.addChildElement("in" + params.indexOf(s));
            soapElement1.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance", "type", "d:string");
            soapElement1.setTextContent(s);
        }
        return soapMessage;
    }

    /**
     * 打印SOAP信息
     *
     * @param soapMessage 要打印的SOAP对象
     * @throws TransformerException
     * @throws SOAPException
     */
    private static void printSOAPMessage(SOAPMessage soapMessage) throws TransformerException, SOAPException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(soapMessage.getSOAPPart().getContent(), new StreamResult(System.out));
    }

    private static SOAPMessage getSOAPResponse(SOAPMessage request) throws SOAPException {
        return SOAPConnectionFactory.newInstance().createConnection().call(request, TEACHING_SYSTEM_URL);
    }

    public static List<GradeInfoDTO> getStudentGradeDTOList(String studentId) throws SOAPException {
        List<String> params = new ArrayList<>();
        params.add(studentId);
        params.add(TIME_STAMP);
        params.add(HASH);
        SOAPMessage request = getSOAPRequest(params, SoapConstant.Method.GET_STUDENT_GRADE);
        SOAPMessage response = getSOAPResponse(request);
        String json = response.getSOAPBody().getFirstChild().getFirstChild().getTextContent();
        if (json.contains("服务器错误")) {
            logger.error(json + " " + studentId);
            return null;
        }
        return JSONArray.parseArray(json, GradeInfoDTO.class);
    }

    //在2019的上半年 你可以查到2019-2020-1 之前
    //在2019的下半年 你可以查到2019-2020-2 之前
    public static List<ChosenCourseDTO> getAllChosenCourseDTOList(String studentId) throws SOAPException {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int enrollYear = Integer.valueOf(studentId.substring(0, 4));
        List<String> semesterList = new ArrayList<>();
        for (int i = enrollYear; i <= currentYear; i++) {
            semesterList.add(i + "-" + (i + 1) + "-" + "1");
            semesterList.add(i + "-" + (i + 1) + "-" + "2");

        }
        List<ChosenCourseDTO> chosenCourseDTOList = new ArrayList<>();
        for (String semester : semesterList) {
            List<ChosenCourseDTO> list = getChosenCourseDTOListWithSemester(studentId, semester);
            if (list != null) {
                chosenCourseDTOList.addAll(list);
            }
        }

        return chosenCourseDTOList;
    }

    public static void main(String[] args) {
        try {
            List<GradeInfoDTO> list = getStudentGradeDTOList("*");
            //  List<ChosenCourseDTO>chosenCourseDTOList = getAllChosenCourseDTOList("*");
            System.out.println(list);
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }

    public static List<ChosenCourseDTO> getChosenCourseDTOListWithSemester(String studentId, String semester) throws SOAPException {
        List<String> params = new ArrayList<>();
        params.add(studentId);
        params.add(semester);
        params.add(TIME_STAMP);
        params.add(HASH);
        SOAPMessage request = getSOAPRequest(params, SoapConstant.Method.GET_CHOSEN_COURSE);
        SOAPMessage response = getSOAPResponse(request);
        String json = response.getSOAPBody().getFirstChild().getFirstChild().getTextContent();
        if (json.equals("没有数据")) {
            return null;
        }
        return JSONArray.parseArray(json, ChosenCourseDTO.class);

    }
}
