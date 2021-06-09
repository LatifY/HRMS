import React, { useState, useEffect } from "react";
import DataTableProfile from "../DataTableProfile";
import DataTable from "../DataTable"
import { PersonnelService } from "../../services/personnelService";

export default function PersonnelController() {

  const [personnels, setPersonnels] = useState([]);

  useEffect(() => {
    let personnelService = new PersonnelService();
    personnelService
      .getAll()
      .then((response) => setPersonnels(response.data.data));
  });

  const headerCells = [
    "Id",
    "Personel",
    "E-Posta",
    "Şifre",
  ];

  var cells = []

  return (
    <>
      {personnels.map((personnel) => {
        var cell = [];
        cell.push(personnel.userId);
        cell.push(
          <DataTableProfile
            header={personnel.firstName + " " + personnel.lastName}
          />
        );
        cell.push(personnel.user.email);
        cell.push(personnel.user.password);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
