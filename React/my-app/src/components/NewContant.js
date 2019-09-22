import React, { Component } from "react";
import { Layout } from 'antd';
import LeftMenu from './LeftMenu'
import UserList from './UserList'
const { Content } = Layout;

const NewContant = (props) => {
  return (
    <Content style={{ padding: '0 50px' }}>
      <Layout style={{ padding: '24px 0', background: '#fff' }}>
        <LeftMenu store={props.store}/>
        <Content style={{ padding: '0 24px', minHeight: 280 }}><UserList store={props.store}/></Content>
      </Layout>
    </Content>
  );
}
export default NewContant;