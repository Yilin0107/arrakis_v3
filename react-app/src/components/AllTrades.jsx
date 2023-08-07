import React, { useState, useEffect } from 'react';
import TradesDetail from './TradesDetail';
import Row from 'react-bootstrap/Row';
import { getAllTrades } from '../services/trade-service';

const AllTrades = () => {
  const [trades, setTrades] = useState([]);
  const [filterTradeType, setFilterTradeType] = useState(''); // Filter by bond type (e.g., 'CORP', 'GOVN', 'SOVN')
  const [filterTradeCurrency, setFilterTradeCurrency] = useState('');
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
    // Add more filtering conditions here for other criteria if needed
    return true;
  });

   const toggleFilters = () => {
     setShowFilters(!showFilters);
   };

  const filterContainerStyle = {
      display: 'flex',
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
                     <label className="filter-label">Filter by Trade Type:</label>
                     <select value={filterTradeType} onChange={(e) => setFilterTradeType(e.target.value)}>
                       <option value="">All</option>
                       <option value="buy">Buy</option>
                       <option value="sell">Sell</option>
                     </select>
                   </div>

                   <div className="filter-container">
                     <label className="filter-label">Filter by Trade Currency:</label>
                     <select value={filterTradeCurrency} onChange={(e) => setFilterTradeCurrency(e.target.value)}>
                       <option value="">All</option>
                       <option value="USD">USD</option>
                       <option value="GBP">GBP</option>
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