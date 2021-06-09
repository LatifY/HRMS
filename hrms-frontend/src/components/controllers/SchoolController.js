import React, { useState, useEffect } from 'react'
import DataTable from "../DataTable"
import { SchoolService } from "../../services/schoolService";

export default function SchoolController() {
  const [schools, setSchools] = useState([]);

  useEffect(() => {
    let schoolService = new SchoolService();
    schoolService
      .getAll()
      .then((response) => setSchools(response.data.data));
  });

  const headerCells = [
    "Id",
    "Özgeçmiş Id",
    "Okul Adı",
    "Okul Departmanı",
    "Başlangıç Yılı",
    "Bitiş Yılı",
  ];

  var cells = []

  return (
    <>
      {schools.map((school) => {
        var cell = [];
        cell.push(school.id);
        cell.push(school.resumeId);
        cell.push(school.schoolName);
        cell.push(school.schoolDepartment);
        cell.push(school.startYear);
        cell.push(school.endYear);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
