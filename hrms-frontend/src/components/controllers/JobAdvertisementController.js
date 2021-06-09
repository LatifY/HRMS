import React, { useState, useEffect } from "react";
import DataTableProfile from "../DataTableProfile";
import DataTable from "../DataTable";
import { JobAdvertisementService } from "../../services/jobAdvertisementService";

export default function JobAdvertisementController() {
  const [jobAdvertisements, setJobAdvertisements] = useState([]);

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService
      .getAll()
      .then((response) => setJobAdvertisements(response.data.data));
  });

  const headerCells = [
    "Id", 
    "Şirket",
    "Aktif", 
    "Açıklama", 
    "İş Pozisyonu",
    "Mevcut İş Pozisyonu Sayısı",
    "Şehir",
    "Maaş",
    "Yayın Tarihi",
    "Bitiş Tarihi",
  ];

  var cells = []

  return (
    <>
      {jobAdvertisements.map((jobAdvertisement) => {
        var employer = jobAdvertisement.employer;
        var cell = [];
        cell.push(jobAdvertisement.id);
        cell.push(
          <DataTableProfile
            header={employer.companyName}
            subHeader={employer.user.email}
          />
        );
        cell.push(jobAdvertisement.description.substring(0,10) + "...")
        cell.push(jobAdvertisement.position.positionName)
        cell.push(jobAdvertisement.openPositionsAmount)
        cell.push(jobAdvertisement.city.cityName)
        cell.push(`${jobAdvertisement.minSalary} - ${jobAdvertisement.maxSalary}`)
        cell.push(jobAdvertisement.releaseDate.substring(0,10))
        cell.push(jobAdvertisement.deadline.substring(0,10))
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
