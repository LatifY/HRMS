import React, { Component } from "react";
import { Header, Image } from "semantic-ui-react";

export default class DataTableProfile extends Component {
  buildImage = () => {
    if (this.props.image) {
      return <Image src={this.props.image} rounded size="mini" />;
    }
  };

  render() {
    return (
      <>
        <Header as="h4" image>
          {this.buildImage()}
          <Header.Content>
            {this.props.header}
            <Header.Subheader>{this.props.subHeader}</Header.Subheader>
          </Header.Content>
        </Header>
      </>
    );
  }
}
