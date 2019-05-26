---
title: course-helper-api
date: 2019-05-26 13:45:31
tags:
---

# API

## 一、收藏（/collection）

### 1. 收藏&取消收藏（/）

POST Auth

##### 参数

1. ownerId：课程代码
2. type：类型 0课程，1 文件， ...其他待补充

##### 返回值

1. 取消收藏返回 0 
2. 收藏返回 1







## 二、课程 （/course）

### 1. 用户收藏课程（/collection)

GET Auth

##### 参数

无

##### 返回值

课程列表数组 每一个课程格式如下

``` json
{
            "course": {
                "courseCode": "0603016",
                "courseName": "毛泽特色社会主义理论体系概论",
                "courseCredit": "6",
                "courseHour": 96,
                "courseType": 1,
                "courseTypeName": "通识教育平台课程",
                "unitName": "马克思主义中国化系"
            },
            "averageRate": 2,
            "teacherList": null,
            "commentVOList": null,
            "commentNum": 7,
            "fileNum": 5,
            "collectionNum": 1,
            "collected": false
        }
    ]
```





### 2. 热门课程 （/hot） 

GET NoAuth

##### 参数

无

##### 返回值

同上





### 3. 推荐课程（/recommend）

分两种情况

1. 已登录 GET Auth

2. 未登录 GET NoAuth

是否登录只需要判断微信数据缓存中是否有 token

##### 参数

无

##### 返回值

同上





### 4.按学院筛选课程（/college/{collegeCode}）

学院代码collegeCode直接拼接在url后面

GET NoAuth

##### 参数

无

##### 返回值

同上





### 5. 对课程名称模糊搜索（/search）

GET NoAuth

##### 参数

keyword：关键词

##### 返回值

同上





### 6. 全部课程（/）

GET NoAuth

##### 参数

1. page：第几页
2. size：每页数据条数

##### 返回值

课程列表在返回值的list中

```json
{
        "pageNum": 1,
        "pageSize": 10,
        "size": 10,
        "orderBy": null,
        "startRow": 1,
        "endRow": 10,
        "total": 2991,
        "pages": 300,
        "list": [
            {
                "course": {
                    "courseCode": "0101015",
                    "courseName": "工程测量",
                    "courseCredit": "3",
                    "courseHour": 46,
                    "courseType": 1,
                    "courseTypeName": "专业核心课程",
                    "unitName": "采矿工程教研室"
                },
                "averageRate": 0,
                "teacherList": null,
                "commentVOList": null,
                "commentNum": 0,
                "fileNum": 0,
                "collectionNum": 0,
                "collected": false
            }
        ],
        "prePage": 0,
        "nextPage": 2,
        "isFirstPage": true,
        "isLastPage": false,
        "hasPreviousPage": false,
        "hasNextPage": true,
        "navigatePages": 8,
        "navigatepageNums": [
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8
        ],
        "navigateFirstPage": 1,
        "navigateLastPage": 8,
        "firstPage": 1,
        "lastPage": 8
    }
```

### 7. 课程详细信息（/{courseCode}）

分两种情况

1. 已登录 GET Auth

2. 未登录 GET NoAuth

是否登录只需要判断微信数据缓存中是否有 token

##### 参数

无

##### 返回值

```json
{
        "course": {
            "courseCode": "1302083",
            "courseName": "人工智能导论",
            "courseCredit": "2",
            "courseHour": 40,
            "courseType": 2,
            "courseTypeName": "学科基础平台课程",
            "unitName": "软件工程教研室"
        },
        "teacherList": [
            {
                "teacherName": "杜立智",
                "average": 72.2797619047619
            },
            {
                "teacherName": "刘钊",
                "average": 68.35207100591715
            }
        ],
        "commentVOList": [
            {
                "comment": {
                    "id": 30,
                    "ownerId": "1302083",
                    "fromId": 11,
                    "likeNum": 1,
                    "content": "刘老师赛高",
                    "createTime": "2019-05-26T00:54:50.000+0000",
                    "updateTime": "2019-05-26T00:58:55.000+0000",
                    "rate": 3
                },
                "userVO": {
                    "id": 11,
                    "nickname": ":)",
                    "avatarUrl": "https://wx.qlogo.cn/mmopen/vi_32/ojpyD",
                    "gender": 2,
                    "studentId": "201719032018",
                    "state": 0
                },
                "like": false
            }
        ],
   			"averageRate": 1,
        "fileNum": 0,
        "collectionNum": 0,
        "collected": false
    }

```

## 三、用户（/user）

### 1. 登录（/login）

POST NoAuth

##### 参数

``` json
{
  "code":"wx.login 获取的code",
  "userInfo": "wx获取到的userInfo"
}
```

##### 返回值

1. token 调用需要验证的接口时的凭证，请储存该token

### 2. 获取用户信息（/）

GET Auth

##### 参数

无

##### 返回值

``` json
{
  "id": 1,
  "nickname":"nickname",
  "avatarUrl":"头像url",
  "gender": 1,
  "studentId":"222222",
  "state":0
}
```



### 3. 绑定（/bind）

POST Auth

绑定失败会进入统一错误处理。

##### 参数

1. 学号：" 2017xxxxxxxx"
2. 姓名：" xxxx"

##### 返回值

无

## 四、 点赞（/like）

###1. 点赞 & 取消点赞（/）

POST Auth

##### 参数

1. ownerId: 2 被点赞的id

##### 返回值

无

## 五、文件（/file）

### 上传文件（/）

POST Auth

1. 

## 六、意见反馈（/feedback）

### 1. 提交反馈（/）

POST NoAuth

##### 参数

1. 反馈内容

##### 返回值

无



