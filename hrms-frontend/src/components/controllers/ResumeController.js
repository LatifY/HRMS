import React, { useState, useEffect } from "react";
import { ResumeService } from "../../services/resumeService";
import DataTableProfile from "../DataTableProfile";
import DataTable from "../DataTable";
import * as constants from "../../constants/constantsMethods"

export default function ResumeController() {
  const [resumees, setResumees] = useState([]);

  useEffect(() => {
    let resumeService = new ResumeService();
    resumeService.getAll().then((response) => setResumees(response.data.data));
  });

  const headerCells = [
    "Id",
    "Çalışan",
    "Açıklama",
    "Github",
    "Linkedin",
    "Beceriler",
    "Okul",
    "İş Tecrübeleri",
    "Diller",
  ];

  var cells = []


  return (
    <>
      {resumees.map((resume) => {
        const employee = resume.employee
        const cell = []
        cell.push(resume.id)
        cell.push(
          <DataTableProfile
            header={employee.firstName + " " + employee.lastName}
            subHeader={employee.user.email}
          />
        )
        cell.push(resume.description)
        cell.push(resume.githubUrl)
        cell.push(resume.linkedinUrl)
        cell.push(constants.listToSeparatedText(resume.abilities))
        cell.push(resume.abilities.length)
        cell.push(resume.schools.length)
        cell.push(resume.jobExperiences.length)
        cell.push(resume.languages.length)
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
