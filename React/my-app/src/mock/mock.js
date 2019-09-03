// 使用 Mock
import Mock from 'mockjs'
import FetchMock from 'fetch-mock';

// mock生成地址 http://mockjs.com/
export default FetchMock.once('http://localhost:3000/userlist', Mock.mock({
    success: true,
    message: '@cparagraph',
    // 属性 list 的值是一个数组，其中含有 1 到 5 个元素
    'list|50-100': [{
        // 属性 sid 是一个自增数，起始值为 1，每次增 1
        'sid|+1': 1,
        // 属性 name  生成一个字符串，重复次数大于等于 1，小于等于 5。
        'name|1':['张三','滕毅','康毛','罗苗','网二'],
        // 生成一个大于等于 20、小于等于 60 的整数，属性值 number 只是用来确定类型。
        'age|1':['20','21','18','44'],

        'addr|1': ['北京市','天津市','山西省','天津市']
    }]
}))
