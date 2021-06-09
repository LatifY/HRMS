import React, { useState, useEffect } from 'react'
import DataTable from "../DataTable"
import { JobExperienceService } from "../../services/jobExperienceService";

export default function JobExperienceController() {
  const [jobExperiences, setJobExperiences] = useState([]);

  useEffect(() => {
    let jobExperienceService = new JobExperienceService();
    jobExperienceService
      .getAll()
      .then((response) => setJobExperiences(response.data.data));
  });

  const headerCells = [
    "Id",
    "Şirket Adı",
    "İş Pozisyonu Adı",
    "Başlangıç Yılı",
    "Bitiş Yılı"
  ];

  var cells = []

  return (
    <>
      {jobExperiences.map((jobExperience) => {
        var cell = [];
        cell.push(jobExperience.id);
        cell.push(jobExperience.companyName);
        cell.push(jobExperience.positionName);
        cell.push(jobExperience.startYear);
        cell.push(jobExperience.endYear);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
