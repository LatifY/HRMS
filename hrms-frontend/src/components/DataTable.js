import React, { Component } from "react";
import { Table, Image, Header } from "semantic-ui-react";

export default class DataTable extends Component {
  render() {
    return (
      <>
        <Table basic="very" celled>
          <Table.Header>
            <Table.Row>
              {this.props.headerCells.map((header) => (
                <Table.HeaderCell>{header}</Table.HeaderCell>
              ))}
            </Table.Row>
          </Table.Header>

          <Table.Body>
            {this.props.cells.map((cell) => (
              <Table.Row>
                {cell.map((item) => (
                  <Table.Cell>{item}</Table.Cell>
                ))}
              </Table.Row>
            ))}
          </Table.Body>
        </Table>
      </>
    );
  }
}
