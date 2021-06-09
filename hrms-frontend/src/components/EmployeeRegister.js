import React, { Component } from "react";
import {
  Grid,
  Header,
  Segment,
  Form,
  Button,
  Message,
  Tab,
} from "semantic-ui-react";

export default class EmployeeRegister extends Component {
  render() {
    return (
      <>
        <Form.Group widths="equal">
          <Form.Input
            fluid
            icon="user"
            iconPosition="left"
            placeholder="Ad"
            required
          />
          <Form.Input
            fluid
            icon="user"
            iconPosition="left"
            placeholder="Soyad"
            required
          />
        </Form.Group>

        <Form.Input
          fluid
          icon="id card"
          iconPosition="left"
          placeholder="TC Kimlik No"
          required
        />

        <Form.Input
          fluid
          icon="birthday"
          iconPosition="left"
          placeholder="Doğum Yılı"
          type="number"
          required
        />

        <Form.Input
          fluid
          icon="mail"
          iconPosition="left"
          placeholder="E-Posta"
          type="email"
          required
        />

        <Form.Group widths="equal">
          <Form.Input
            fluid
            icon="lock"
            iconPosition="left"
            placeholder="Şifre"
            type="password"
            required
          />
          <Form.Input
            fluid
            icon="lock"
            iconPosition="left"
            placeholder="Şifre Tekrarı"
            type="password"
            required
          />
        </Form.Group>

        <br />
        
        <Button color="teal" fluid size="large">
          Kayıt Ol
        </Button>
      </>
    );
  }
}
