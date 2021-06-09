import React from "react";
import { Segment, Tab, Label } from "semantic-ui-react";

import UserController from "../components/controllers/UserController";
import ResumeController from "../components/controllers/ResumeController"
import PositionController from "../components/controllers/PositionController"
import SchoolController from "../components/controllers/SchoolController"
import CityController from "../components/controllers/CityController"
import LanguageController from "../components/controllers/LanguageController"
import AbilityController from "../components/controllers/AbilityController"
import JobExperienceController from "../components/controllers/JobExperienceController"
import JobAdvertisementController from "../components/controllers/JobAdvertisementController"

export default function Dashboard() {
  const tabs = [
    {
      menuItem: "Kullanıcılar",
      render: () => <UserController />,
    },
    {
      menuItem: "Özgeçmiş",
      render: () => <ResumeController />,
    },
    {
      menuItem: "İş Pozisyonu",
      render: () => <PositionController />,
    },
    {
      menuItem: "Okul",
      render: () => <SchoolController />,
    },
    {
      menuItem: "Şehir",
      render: () => <CityController />,
    },
    {
      menuItem: "Dil",
      render: () => <LanguageController />,
    },
    {
      menuItem: "Beceri",
      render: () => <AbilityController />,
    },
    {
      menuItem: "İş Tecrübesi",
      render: () => <JobExperienceController />,
    },
    {
      menuItem: "İş İlanı",
      render: () => <JobAdvertisementController />,
    },
  ];

  return (
    <div className="dashboard">
      <Segment raised>
        <Tab panes={tabs} menu={{ secondary: true }} />
        <br/>
      </Segment>
    </div>
  );
}
