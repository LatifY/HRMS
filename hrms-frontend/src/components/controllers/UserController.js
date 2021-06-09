import React from "react";
import { Segment, Tab } from "semantic-ui-react";
import EmployeeController from "./EmployeeController";
import EmployerController from "./EmployerController";
import PersonnelController from "./PersonnelController";

export default function UserController() {
  const tabs = [
    {
      menuItem: "Çalışan",
      render: () => <EmployeeController />
    },
    {
      menuItem: "İş Veren",
      render: () => <EmployerController />
    },
    {
      menuItem: "Personel",
      render: () => <PersonnelController />
    },
  ];

  return (
    <>
      <Segment raised>
        <Tab panes={tabs} menu={{ secondary: true }}/>
      </Segment>
    </>
  );
}
