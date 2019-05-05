package me.xiaoyuu.course_helper.util;

import com.alibaba.fastjson.JSONArray;
import me.xiaoyuu.course_helper.constant.SoapConstant;
import me.xiaoyuu.course_helper.dto.GradeInfoDTO;

import javax.xml.soap.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;
import java.util.List;

import static me.xiaoyuu.course_helper.constant.SoapConstant.*;

public class SOAPUtil {


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

    public static List<GradeInfoDTO> getStudentGradeList(String studentId) throws SOAPException {
        List<String> params = new ArrayList<>();
        params.add(studentId);
        params.add(TIME_STAMP);
        params.add(HASH);
        SOAPMessage request = getSOAPRequest(params, SoapConstant.Method.GET_STUDENT_GRADE);
        SOAPMessage response = getSOAPResponse(request);
        String json = response.getSOAPBody().getFirstChild().getFirstChild().getTextContent();
        return JSONArray.parseArray(json, GradeInfoDTO.class);
    }

    public static String getChosenCourseJSON(String studentId, String semester) throws SOAPException {
        List<String> params = new ArrayList<>();
        params.add(studentId);
        params.add(semester);
        params.add(TIME_STAMP);
        params.add(HASH);
        SOAPMessage request = getSOAPRequest(params, SoapConstant.Method.GET_CHOSEN_COURSE);
        SOAPMessage response = getSOAPResponse(request);
        return response.getSOAPBody().getFirstChild().getFirstChild().getTextContent();
    }
}
