import React , {useState, useEffect} from 'react';
import BondsDetail from './BondsDetail';
import Test from './Test';
import Row from 'react-bootstrap/Row';
import { getAllBonds } from '../services/bond-service';

const AllBonds = () => {
  const [bonds, setBonds] = useState([]);
  const [filterType, setFilterType] = useState(''); // Filter by bond type (e.g., 'CORP', 'GOVN', 'SOVN')
  const [filterCurrency, setFilterCurrency] = useState('');
  const [filterIssuerName, setFilterIssuerName] = useState('')
  const [filterEmployeeId, setFilterEmployeeId] =  useState('') // Filter by currency (e.g., 'USD', 'GBP')
  // Add more state variables for other filter criteria if needed

  useEffect(() => {
    getBondsFromAPI();
  }, []);

  const getBondsFromAPI = () => {
    getAllBonds()
      .then(res => {
        setBonds(res.data);
      })
      .catch(err => {
        setBonds([]);
        console.log(err);
      });
  };

  // Filter the bonds based on the selected criteria
  const filteredBonds = bonds.filter(bond => {
    // Filter by bond type
    if (filterType && bond.type !== filterType) {
      return false;
    }
    // Filter by currency
    if (filterCurrency && bond.bondCurrency !== filterCurrency) {
      return false;
    }

    if (filterEmployeeId && bond.employeeId.toString !== filterEmployeeId) {
               return false;
    }
    // Add more filtering conditions here for other criteria if needed
    return true;
  });

  return (
    <div>
      <div>
        <label>Filter by Type:</label>
        <select
          value={filterType}
          onChange={e => setFilterType(e.target.value)}
        >
          <option value="">All</option>
          <option value="CORP">CORP</option>
          <option value="GOVN">GOVN</option>
          <option value="SOVN">SOVN</option>
          {/* Add more options based on your bond types */}
        </select>
      </div>
      <div>
        <label>Filter by Currency:</label>
        <select
          value={filterCurrency}
          onChange={e => setFilterCurrency(e.target.value)}
        >
          <option value="">All</option>
          <option value="USD">USD</option>
          <option value="GBP">GBP</option>
          {/* Add more options based on your bond currencies */}
        </select>
      </div>

       <div>
              <label>Filter by Employee Id:</label>
              <select
                value={filterEmployeeId}
                onChange={e => setFilterType(e.target.value)}
              >
                <option value="">All</option>
                <option value="1000">1000</option>
                <option value="1001">1001</option>
                <option value="1002">1002</option>
                <option value="1003">1003</option>
                <option value="1004">1004</option>
              </select>
            </div>

            <div>
            <Test />
            </div>


      <Row>
        {filteredBonds.map(bond => (
          <div className='container' key={bond.isin}>
            <BondsDetail info={bond} />
          </div>
        ))}
      </Row>
    </div>
  );
};

export default AllBonds;