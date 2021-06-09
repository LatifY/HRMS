import React, { useState } from "react";
import { Grid, Header, Segment, Form, Button, Message } from "semantic-ui-react"
import { Link } from "react-router-dom"
import undraw_login from "../assets/images/undraw_login.png"

export default function Login() {

  return (
    <>
      <Grid
        textAlign="center"
        style={{ height: "80vh" }}
        verticalAlign="middle"
      >
        <Grid.Column style={{ maxWidth: 450 }}>
          <Header as="h1" color="teal" textAlign="center">
            Giriş Yap
          </Header>
          <Form size="large">
            <Segment stacked>
              <Form.Input
                fluid
                icon="user"
                iconPosition="left"
                placeholder="E-Posta"
                type="email"
                required
              />
              <Form.Input
                fluid
                icon="lock"
                iconPosition="left"
                placeholder="Şifre"
                type="password"
                required
              />

              <Button color="teal" fluid size="large">
                Giriş Yap
              </Button>
            </Segment>
          </Form>
          <Message>
            <h4>Hesabınız yok mu? <Link style={{ color: "#00b5ad" }} to="/register">Kayıt olun!</Link></h4> 
          </Message>
        </Grid.Column>
      </Grid>
      <img src={undraw_login} width="560" style={{ position: "fixed", bottom: 10, right: 10 }} />
    </>
  );
}
