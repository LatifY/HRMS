import React, { Component } from "react";
import { Button, Container, Menu, Dropdown } from "semantic-ui-react";
import { Link } from "react-router-dom";
import "../assets/css/style.css";

export default class Navi extends Component {
  state = { activeItem: "anasayfa" };
  handleItemClick = (e, { name }) => this.setState({ activeItem: name });

  render() {
    const { activeItem } = this.state;

    return (
      <>
        <Link
          to="/home"
          style={{ color: "#00b5ad" }}
          active={activeItem === "anasayfa"}
          onClick={() => this.setState({ activeItem: "anasayfa" })}
        >
          <h1 className="logo" style={{ fontSize: 35, paddingTop: 10 }}>
            HRMS
          </h1>
        </Link>

        <Menu
          size="large"
          secondary
          pointing
          color="teal"
          style={{ height: 0 }}
        >
          <Container>
            <Menu.Item
              active
              as={Link}
              link="true"
              to="/home"
              name="anasayfa"
              active={activeItem === "anasayfa"}
              onClick={this.handleItemClick}
            ></Menu.Item>
            <Menu.Item
              as={Link}
              link="true"
              name="panel"
              to="/dashboard"
              active={activeItem === "panel"}
              onClick={this.handleItemClick}
            />
            <Menu.Item position="right">

              <Button
                color="teal"
                as={Link}
                to="/login"
                name="login"
                link="true"
                active={activeItem === "login"}
                onClick={this.handleItemClick}
                style={{ marginLeft: "1em" }}
              >
                Giriş yap
              </Button>
              <Button
                color="teal"
                as={Link}
                to="/register"
                name="register"
                link="true"
                active={activeItem === "register"}
                onClick={this.handleItemClick}
                style={{ marginLeft: "1em" }}
              >
                Kayıt ol
              </Button>
            </Menu.Item>
          </Container>
        </Menu>
      </>
    );
  }
}


/*              <Dropdown text="Controllers">
                <Dropdown.Menu>
                  <Dropdown.Item as={Link} to></Dropdown.Item>
                  <Dropdown.Item>Russian</Dropdown.Item>
                  <Dropdown.Item>Spanish</Dropdown.Item>
                </Dropdown.Menu>
              </Dropdown>*/
