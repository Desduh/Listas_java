import '../../style.css';
import { useState } from "react";

import Header from '../../../components/Header';
import Title from '../../../components/Title';

import MultiStepProgressBar from "../../../components/MultiStepProgressBar";

import Pessoal from './Pessoal';
import Documentos from './Documentos';
import Endereco from './Endereco';

import { MdPeopleOutline } from "react-icons/md";

export default function CadastrarTitular() {
  const [page, setPage] = useState("pageone");

  const nextPage = (page) => {
    setPage(page);
  };

  const nextPageNumber = (pageNumber) => {
    switch (pageNumber) {
      case "1":
        setPage("pageone");
        break;
      case "2":
        setPage("pagetwo");

        break;
      case "3":
        setPage("pagethree");
        break;
      default:
        setPage("1");
    }
  };

  return (
    <div>
      <Header />
      <div className="content">
        <Title name="Cliente">
          <MdPeopleOutline color="#8b8da5" size={25}/>
        </Title>

        <MultiStepProgressBar page={page} />
        {
          {
            pageone: <Pessoal onButtonClick={nextPage} />,
            pagetwo: <Documentos onButtonClick={nextPage} />,
            pagethree: <Endereco onButtonClick={nextPage} />
          }[page]
        }
      </div>
    </div>
  );
}