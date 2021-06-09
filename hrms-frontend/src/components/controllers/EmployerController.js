import React, { useState, useEffect } from "react";
import DataTableProfile from "../DataTableProfile";
import DataTable from "../DataTable";
import { EmployerService } from "../../services/employerService";

export default function EmployerController() {
  const [employers, setEmployers] = useState([]);

  useEffect(() => {
    let employerService = new EmployerService();
    employerService
      .getAll()
      .then((response) => setEmployers(response.data.data));
  });

  const headerCells = ["Id", "Şirket", "Telefon No", "E-Posta", "Şifre"];

  var cells = []

  return (
    <>
      {employers.map((employer) => {
        var cell = [];
        cell.push(employer.userId);
        cell.push(
          <DataTableProfile
            header={employer.companyName}
            subHeader={employer.website}
          />
        );
        cell.push(employer.phone);
        cell.push(employer.user.email);
        cell.push(employer.user.password);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
