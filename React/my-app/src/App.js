import React, { Component } from 'react';
import './App.css';
import HeaderComponent from './components/HeaderComponent';
import NewContant from './components/NewContant';
import FooterComponent from './components/FooterComponent'
import { Layout } from 'antd';
import "antd/dist/antd.css";
import ModalComponent from './components/ModalComponent'

class App extends Component {
  render() {
    return (
      <Layout>
        <HeaderComponent />
        <NewContant store={this.props.store}/>
        <FooterComponent />
        <ModalComponent store={this.props.store}/>
      </Layout>
    );
  }
}

export default App;
