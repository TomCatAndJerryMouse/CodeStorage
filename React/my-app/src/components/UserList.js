import React, { Component } from 'react';
import '../myTable.css'
import '../mock/mock' //挂载 Mock
import { Table, Button, Divider } from 'antd';

class List extends Component {

    // 生命周期函数 组件构造函数 
    constructor(props) {
        console.log("List Component constructor");
        super(props);
        // 需要将orops里参数绑定到state里才能通过修改state里的数据才能达到数据实时更新到dom
        this.state = {
            isLoading: true,
            datas: props.datas
        }
    }

    //生命周期函数 组件第一次渲染前调用  可以在这里获取服务端数据
    componentWillMount() {
        console.log("List Component componentWillMount");
        // 发送ajx请求获取数据 ，毁掉使用箭头函数，函数内才能使用this
        fetch('http://localhost:3000/userlist').then(res => {
            return res.json()
        }).then(json => {
            console.log(json.list);
            this.setState({
                isLoading: false,
                dataSource: json.list
            })
        })
    }

    // 生命周期函数 渲染组件调用
    render() {
        const columns = [
            {
                title: '姓名',
                dataIndex: 'name',
                key: 'name',
            },
            {
                title: '年龄',
                dataIndex: 'age',
                key: 'age',
            },
            {
                title: '住址',
                dataIndex: 'address',
                key: 'address',
            },
            {
                title: '操作',
                key: 'action',
                render: (record) => (
                    <span>
                        <Button type="primary" onClick={this.delet.bind(this, record)}>删除</Button>
                    </span>
                ),
            },
        ];
        console.log("List Component render");
        return (
            <Table dataSource={this.state.dataSource} columns={columns} > </Table>
        );
    }

    // 生命周期函数  组件第一次渲染后调用
    componentDidMount() {
        console.log("List Component componentDidMount");
    }

    // 生命周期函数  组件接受新的peops调用
    componentWillReceiveProps() {
        console.log("List Component componentWillReceiveProps");
    }

    // 生命周期函数 是否要跟新组件返回blooean值
    shouldComponentUpdate() {
        console.log("List Component shouldComponentUpdate");
        return true;
    }

    // 生命周期函数 组件 执行完了以后又会调用reander函数
    componentWillUpdate() {
        console.log("List Component componentWillUpdate");
    }

    //生命周期函数 组件跟新完成后调用
    componentDidUpdate() {
        console.log("List Component componentDidUpdate");
    }

    // 删除事件
    delet(record) {
        this.props.store.dispatch({ type: "SHOWMODAL" });
        console.log(record);
        // 通过react提供setState函数跟新state中的数据。从下标为index开始删除数组中的1个
        this.state.dataSource.splice(record.sid, 1);
        this.setState({
            dataSource: this.state.dataSource
        })
        console.log("删除后");
        console.log(this.state.dataSource);
    }
}
export default List;
