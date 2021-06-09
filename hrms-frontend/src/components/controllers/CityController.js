import React, { useState, useEffect } from 'react'
import DataTable from "../DataTable"
import { CityService } from "../../services/cityService";

export default function CityController() {
  const [cities, setCities] = useState([]);

  useEffect(() => {
    let cityService = new CityService();
    cityService
      .getAll()
      .then((response) => setCities(response.data.data));
  });

  const headerCells = [
    "Id",
    "Şehir Adı",
  ];

  var cells = []

  return (
    <>
      {cities.map((city) => {
        var cell = [];
        cell.push(city.id);
        cell.push(city.cityName);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
