import React, { useState, useEffect } from "react";
import DataTableProfile from "../DataTableProfile";
import DataTable from "../DataTable";
import { EmployeeService } from "../../services/employeeService";

export default function EmployeeController() {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    let employeeService = new EmployeeService();
    employeeService
      .getAll()
      .then((response) => setEmployees(response.data.data));
  });

  const headerCells = [
    "Id",
    "Çalışan",
    "TC Kimlik No",
    "Doğum Yılı",
    "E-Posta",
    "Şifre",
  ];

  const image = "https://react.semantic-ui.com/images/avatar/small/matthew.png";

  var cells = []

  return (
    <>
      {employees.map((employee) => {
        var cell = [];
        cell.push(employee.userId);
        cell.push(
          <DataTableProfile
            image={image}
            header={employee.firstName + " " + employee.lastName}
            subHeader={employee.position.positionName}
          />
        );
        cell.push(employee.identityNo);
        cell.push(employee.birthYear);
        cell.push(employee.user.email);
        cell.push(employee.user.password);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
