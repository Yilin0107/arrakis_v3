import React, { useState, useEffect } from 'react';
import TradesDetail from './TradesDetail';
import Row from 'react-bootstrap/Row';
import { getAllTrades } from '../services/trade-service';



const AllTrades = () => {
  const [trades, setTrades] = useState([]);
  const [filterTradeType, setFilterTradeType] = useState(''); // Filter by bond type (e.g., 'CORP', 'GOVN', 'SOVN')
  const [filterTradeCurrency, setFilterTradeCurrency] = useState('');

  const [filterIsin, setFilterIsin] = useState('')
  const [filterBookName, setFilterBookName] = useState('')
  const [filterBondHolder, setFilterBondHolder] = useState('')
  const [filterTradeStatus, setFilterTradeStatus] = useState('')

  const [showFilters, setShowFilters] = useState(false);

  // Add more state variables for other filter criteria if needed

  useEffect(() => {
    getTradesFromAPI();
  }, []);

  const getTradesFromAPI = () => {
    getAllTrades()
      .then(res => {
        setTrades(res.data);
      })
      .catch(err => {
        setTrades([]);
        console.log(err);
      });
  };

  // Filter the bonds based on the selected criteria
  const filteredTrades = trades.filter(trade => {
    // Filter by bond type
    if (filterTradeType && trade.tradeType !== filterTradeType) {
      return false;
    }
    // Filter by currency
    if (filterTradeCurrency && trade.tradeCurrency !== filterTradeCurrency) {
      return false;
    }

  if (filterIsin && trade.isin !== filterIsin) {
    return false;
  }

    if (filterBookName && trade.bookName !== filterBookName) {
          return false;
        }
    if (filterBondHolder && trade.bondHolder !== filterBondHolder) {
           return false;
         }
    if (filterTradeStatus && trade.tradeStatus !== filterTradeStatus) {
            return false;
          }

    // Add more filtering conditions here for other criteria if needed
    return true;
  });

   const toggleFilters = () => {
     setShowFilters(!showFilters);
   };

  const filterContainerStyle = {
      display: 'inline',
      alignItems: 'center',
      marginBottom: '0.5rem',
      overflow: 'auto'
    };

    const filterLabelStyle = {
      marginRight: '0.5rem',
      fontWeight: 'bold',
    };

    const blueBandStyle = {
      backgroundColor: '#0018a8',
      color: 'white',
      padding: '10px',
      textAlign: 'center',
    };

    //





    return (
     <div>
          {/* Top band */}
          <div style={blueBandStyle}>
            <h1>Trades Detail Page</h1>
          </div>
          <div>
          <br />
          </div>
               <div
                 className="filter-card"
                 style={{ backgroundColor: 'grey', padding: '10px', cursor: 'pointer', display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}
                 onClick={toggleFilters}
               >
                 <h5>Filter Options</h5>
                 <div
                   className="arrow-icon"
                   style={{ width: 0, height: 0, borderLeft: '5px solid transparent', borderRight: '5px solid transparent', borderTop: '8px solid white' }}
                 ></div>
               </div>

               {showFilters && (
                 <div
                   className="filter-options"
                   style={{ display: 'flex', backgroundColor: '#f9f9f9', padding: '10px', border: '1px solid #ccc', borderRadius: '4px' }}
                 >
                   <div className="filter-container">
                     <label className="filter-label">Trade Type:</label>
                     <select value={filterTradeType} onChange={(e) => setFilterTradeType(e.target.value)}>
                       <option value="">All</option>
                       <option value="buy">Buy</option>
                       <option value="sell">Sell</option>
                     </select>
                   </div>

                   <div className="filter-container">
                     <label className="filter-label">Trade Currency:</label>
                     <select value={filterTradeCurrency} onChange={(e) => setFilterTradeCurrency(e.target.value)}>
                       <option value="">All</option>
                       <option value="USD">USD</option>
                       <option value="GBP">GBP</option>
                     </select>
                   </div>

                   <div className="filter-container">
                     <label className="filter-label">Isin:</label>
                     <select  value={filterIsin} onChange={(e) => setFilterIsin(e.target.value)}>
                       <option value="">All</option>
                       <option value="XS1988387210">XS1988387210</option>
                       <option value="A12356111">A12356111</option>
                       <option value="CE00B29LNP67">CE00B29LNP67</option>
                       <option value="GB00B6460505">GB00B6460505</option>
                       <option value="GB00B6460506">GB00B6460506</option>
                       <option value="GB00B6460507">GB00B6460507</option>
                       <option value="GB00B6460508">GB00B6460508</option>
                       <option value="GB00B6460509">GB00B6460509</option>
                       <option value="GB00B6460510">GB00B64605010</option>
                       <option value="GB00B6460511">GB00B6460511</option>
                       <option value="GB00B6460512">GB00B6460512</option>
                       <option value="GB00B6460513">GB00B6460513</option>
                       <option value="GB00B6460514">GB00B6460514</option>
                       <option value="GB00B6460515">GB00B6460515</option>
                       <option value="IE00B29LNP31">IE00B29LNP31</option>
                       <option value="M12356111653">M12356111653</option>
                       <option value="US87973RAA86">US87973RAA86</option>
                       <option value="US87973RAA86">US87973RAA86</option>
                       <option value="USN0280EAR64">USN0280EAR64</option>
                       <option value="USU02320AG12">USU02320AG12</option>
                     </select>
                   </div>

                   <div className="filter-container">
                       <label className="filter-label">Book Name:</label>
                       <select value={filterBookName} onChange={(e) => setFilterBookName(e.target.value)}>
                         <option value="">All</option>
                         <option value="Trading_book_1">Book 1</option>
                         <option value="Trading_book_2">Book 2</option>
                         <option value="Trading_book_3">Book 3</option>
                         <option value="Trading_book_4">Book 4</option>
                         <option value="Trading_book_6">Book 6</option>

                       </select>
                     </div>

                    <div className="filter-container">
                       <label className="filter-label">Bond Holder:</label>
                       <select value={filterBondHolder} onChange={(e) => setFilterBondHolder(e.target.value)}>
                         <option value="">All</option>
                         <option value="AZ Holdings Inc">AZ Holdings Inc</option>
                         <option value="Acme co">Acme co</option>
                         <option value="Acme+A1:R5 Co">Acme+A1:R5 Co</option>
                         <option value="Akayra Holding">Akayra Holding</option>
                         <option value="Astra Trading Ltd">Astra Trading Ltd</option>
                         <option value="Barclays">Barclays</option>
                         <option value="British Telecom">British Telecom</option>
                         <option value="Goldman Sachs">Goldman Sachs</option>
                         <option value="Muncipal Gov Of Orange County">Muncipal Gov Of Orange County</option>
                         <option value="Pension Holdings">Pension Holdings</option>
                         <option value="Sovereign Investments">Sovereign Investments</option>
                         <option value="UBS">UBS</option>
                         <option value="XV Space Ltd">XV Space Ltd</option>
                         <option value="Zurich Pension fund 4">Zurich Pension fund 4</option>


                       </select>
                     </div>

                      <div className="filter-container">
                            <label className="filter-label">Trade Status:</label>
                            <select value={filterTradeStatus} onChange={(e) => setFilterTradeStatus(e.target.value)}>
                              <option value="">All</option>
                              <option value="open">Open</option>
                              <option value="closed">Closed</option>
                            </select>
                       </div>






                 </div>
               )}



        <Row>
          {filteredTrades.map(trade => (
            <div className='container' key={trade.id}>
              <TradesDetail info={trade} />
            </div>
          ))}
        </Row>
      </div>
    );
  };

  export default AllTrades;



