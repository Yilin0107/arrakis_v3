import React , {useState, useEffect} from 'react';
import BondsDetail from './BondsDetail';
import Row from 'react-bootstrap/Row';
import { getAllBonds } from '../services/bond-service';

const AllBonds = () => {
    // const bonds = [
    //     {
    //       isin: 'XS1988387210',
    //       currency: 'USD',
    //       cusip: null,
    //       faceValue: '1000',
    //       issuerName: 'BNPParibasIssu 4,37% Microsoft Corp (USD)',
    //       maturityDate: '2021-08-05',
    //       status: 'active',
    //       type: 'CORP',
    //     },
    //     {
    //       isin: 'USN0280EAR64',
    //       currency: 'USD',
    //       cusip: '123456780',
    //       faceValue: '900',
    //       issuerName: 'Airbus 3.15% USD',
    //       maturityDate: '2021-07-30',
    //       status: 'active',
    //       type: 'CORP',
    //     },
    //     {
    //       isin: 'A12356111',
    //       currency: 'USD',
    //       cusip: '123456bh0',
    //       faceValue: '900',
    //       issuerName: 'UBS Facebook (USD)',
    //       maturityDate: '2021-09-30',
    //       status: 'active',
    //       type: 'CORP',
    //     },
    //     {
    //       isin: 'USU02320AG12',
    //       currency: 'USD',
    //       cusip: null,
    //       faceValue: '900',
    //       issuerName: 'Amazon',
    //       maturityDate: '2021-08-03',
    //       status: 'active',
    //       type: 'CORP',
    //     },
    //     {
    //       isin: 'GB00B6460505',
    //       currency: 'GBP',
    //       cusip: 'BDCHBW8',
    //       faceValue: '900',
    //       issuerName: 'HM Treasury United Kingdom',
    //       maturityDate: '2021-08-09',
    //       status: 'active',
    //       type: 'GOVN',
    //     },

    //     {
    //         isin: 'GB00B6460506',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
          
    //       {
    //         isin: 'GB00B6460507',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460508',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460509',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460510',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460511',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460512',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460513',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460514',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },
    //       {
    //         isin: 'GB00B6460515',
    //         currency: 'GBP',
    //         cusip: 'BDCHBW8',
    //         faceValue: '900',
    //         issuerName: 'HM Treasury United Kingdom',
    //         maturityDate: '2021-08-09',
    //         status: 'active',
    //         type: 'GOVN',
    //       },

    //       {
    //         isin: 'US87973RAA86',
    //         currency: 'USD',
    //         cusip: '87973RAA8',
    //         faceValue: '690',
    //         issuerName: 'TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S',
    //         maturityDate: '2021-08-06',
    //         status: 'active',
    //         type: 'SOVN',
    //       },
    //       {
    //         isin: 'IE00B29LNP31',
    //         currency: 'USD',
    //         cusip: '87973RAA8',
    //         faceValue: '340',
    //         issuerName: 'First Norway Alpha Kl.IV',
    //         maturityDate: '2030-12-22',
    //         status: 'active',
    //         type: 'SOVN',
    //       },
    //       {
    //         isin: 'CE00B29LNP67',
    //         currency: 'USD',
    //         cusip: '98973RAA7',
    //         faceValue: '360',
    //         issuerName: 'ABC Airways',
    //         maturityDate: '2030-11-12',
    //         status: 'active',
    //         type: 'CORP',
    //       },
    //       {
    //         isin: 'M12356111653',
    //         currency: 'GBP',
    //         cusip: '333456bh0',
    //         faceValue: '700',
    //         issuerName: 'UBS MEWS',
    //         maturityDate: '2021-08-30',
    //         status: 'active',
    //         type: 'CORP',
    //       },
          
       
    //   ];
  const [bonds, setBonds] = useState([]);

  useEffect( () =>{
    getBondsFromAPI();},
    []
  );

  const getBondsFromAPI = () => {
    getAllBonds()
  .then(res => {
      setBonds(res.data);
  })
  .catch(err => {
      setBonds([]);
      console.log(err);
  })
  }

  return (
    <Row>
    {bonds.map(bond=>(
        <div className='container' key={bond.isin}>
        <BondsDetail info={bond}  />

        </div>
    ))}
    </Row>
  
    )
}

export default AllBonds

// <BondsDetail info={bonds}/>