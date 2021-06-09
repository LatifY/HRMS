import React, { useState, useEffect } from 'react'
import DataTable from "../DataTable"
import { AbilityService } from "../../services/abilityService";

export default function AbilityController() {
  const [abilities, setAbilities] = useState([]);

  useEffect(() => {
    let abilityService = new AbilityService();
    abilityService
      .getAll()
      .then((response) => setAbilities(response.data.data));
  });

  const headerCells = [
    "Id",
    "Beceri Adı",
  ];

  var cells = []

  return (
    <>
      {abilities.map((ability) => {
        var cell = [];
        cell.push(ability.id);
        cell.push(ability.abilityName);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
