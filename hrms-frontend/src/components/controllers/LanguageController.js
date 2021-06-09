import React, { useState, useEffect } from 'react'
import DataTable from "../DataTable"
import { LanguageService } from "../../services/languageService";

export default function LanguageController() {
  const [languages, setLanguages] = useState([]);

  useEffect(() => {
    let languageService = new LanguageService();
    languageService
      .getAll()
      .then((response) => setLanguages(response.data.data));
  });

  const headerCells = [
    "Id",
    "Dil Adı",
  ];

  var cells = []

  return (
    <>
      {languages.map((language) => {
        var cell = [];
        cell.push(language.id);
        cell.push(language.languageName);
        cells.push(cell)
      })}
      <DataTable headerCells={headerCells} cells={cells} />
    </>
  );
}
