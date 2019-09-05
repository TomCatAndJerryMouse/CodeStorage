import React, { Component } from 'react';
import { Modal, Button } from 'antd';


class ModalComponent extends Component {

    state = { visible: false };
    showModal = () => {
      this.setState({
        visible: true,
      });
    };
  
    handleOk = e => {
      console.log(e);
      this.setState({
        visible: false,
      });
    };
  
    handleCancel = e => {
      console.log(e);
      this.setState({
        visible: false,
      });
    };
    render() {
  
        return (
            <Modal
              title="Basic Modal"
              visible={this.props.store.getState().visible}
              onOk={this.handleOk}
              onCancel={this.handleCancel}>
              <p>Some contents...</p>
              <p>Some contents...</p>
              <p>Some contents...</p>
            </Modal>
        );
    }

}
export default ModalComponent;