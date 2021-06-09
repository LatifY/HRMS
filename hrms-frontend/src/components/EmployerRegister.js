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

export default class EmployerRegister extends Component {

  save = (employee) => {
    
  }

  render() {
    return (
      <>
        <Form.Input
          fluid
          icon="building"
          iconPosition="left"
          placeholder="Şirket Adı"
          required
        />
        <Form.Input
          fluid
          icon="world"
          iconPosition="left"
          placeholder="Website"
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

        <Form.Input
          fluid
          icon="phone"
          iconPosition="left"
          placeholder="Telefon No"
          type="tel"
          pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}"
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
