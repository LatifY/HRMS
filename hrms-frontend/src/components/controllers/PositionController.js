import React, { useState, useEffect } from 'react'
import DataTable from "../DataTable"
import { PositionService } from "../../services/positionService";

export default function PositionController() {
  const [positions, setPositions] = useState([]);

  useEffect(() => {
    let positionService = new PositionService();
    positionService
      .getAll()
      .then((response) => setPositions(response.data.data));
  });

  const headerCells = [
    "Id",
    "İş Pozisyonu Adı",
  ];

  var cells = [];

  return (
    <>
      {positions.map((position) => {
        var cell = []
        cell.push(position.id);
        cell.push(position.positionName);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
