import React, { useState, useEffect } from "react";
import BondsDetail from "./BondsDetail";
import Row from "react-bootstrap/Row";
import { getAllBonds } from "../services/bond-service";
import { getAllBooks } from "../services/book-service";

const AllBonds = () => {
  const handleButtonClick = () => {
    // Navigate to the FinancialDashboard page when the button is clicked
    window.location.href = "/dashboard";
  };

  const [bonds, setBonds] = useState([]);
  const [books, setBooks] = useState([]);
  const [filterType, setFilterType] = useState(""); // Filter by bond type (e.g., 'CORP', 'GOVN', 'SOVN')
  const [filterCurrency, setFilterCurrency] = useState("");
  const [filterEmployeeId, setFilterEmployeeId] = useState("");
  const [filterIssuerName, setFilterIssuerName] = useState(""); // Filter by currency (e.g., 'USD', 'GBP')
  const [showFilters, setShowFilters] = useState(false);

  // Add more state variables for other filter criteria if needed

  useEffect(() => {
    getBondsFromAPI();
  }, []);

  const getBondsFromAPI = () => {
    getAllBonds()
      .then((res) => {
        setBonds(res.data);
      })
      .catch((err) => {
        setBonds([]);
        console.log(err);
      });
  };

  useEffect(() => {
    getBooksFromAPI();
  }, [filterEmployeeId]);

  const getBooksFromAPI = () => {
    getAllBooks(filterEmployeeId)
      .then((res) => {
        setBooks(res.data);
      })
      .catch((err) => {
        setBooks([]);
        console.log(err);
      });
  };
  console.log("books array", books);
  // Filter the bonds based on the selected criteria
  const filteredBonds = bonds.filter((bond) => {
    // Filter by bond type
    if (filterType && bond.type !== filterType) {
      return false;
    }
    // Filter by currency
    if (filterCurrency && bond.bondCurrency !== filterCurrency) {
      return false;
    }

    if (filterEmployeeId && bond.employeeId.toString() !== filterEmployeeId) {
      return false;
    }

    if (filterIssuerName && bond.issuerName.toString() !== filterIssuerName) {
      return false;
    }

    // Add more filtering conditions here for other criteria if needed
    return true;
  });

  const toggleFilters = () => {
    setShowFilters(!showFilters);
  };

  const blueBandStyle = {
    backgroundColor: "#0018a8",
    color: "white",
    padding: "10px",
    textAlign: "center",
  };

  //

  return (
    <div>
      {/* Top band */}
      <div style={blueBandStyle}>
        <h1>Bonds Detail Page</h1>
      </div>
      <div>
        <br />
      </div>
      <div>
        <button class="back-button" onClick={handleButtonClick}>
          Go Back to Navigation Page
        </button>
      </div>
      <div>
        <br />
        <br />
      </div>
      <div
        className="filter-card"
        style={{
          backgroundColor: "grey",
          padding: "10px",
          cursor: "pointer",
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
        onClick={toggleFilters}
      >
        <h5>Filter Options</h5>
        <div
          className="arrow-icon"
          style={{
            width: 0,
            height: 0,
            borderLeft: "5px solid transparent",
            borderRight: "5px solid transparent",
            borderTop: "8px solid white",
          }}
        ></div>
      </div>

      {showFilters && (
        <div
          className="filter-options"
          style={{
            display: "flex",
            backgroundColor: "#f9f9f9",
            padding: "10px",
            border: "1px solid #ccc",
            borderRadius: "4px",
          }}
        >
          <div className="filter-container">
            <label className="filter-label">Filter by Type:</label>
            <select
              value={filterType}
              onChange={(e) => setFilterType(e.target.value)}
            >
              <option value="">All</option>
              <option value="CORP">CORP</option>
              <option value="GOVN">GOVN</option>
              <option value="SOVN">SOVN</option>
            </select>
          </div>

          <div className="filter-container">
            <label className="filter-label">Filter by Currency:</label>
            <select
              value={filterCurrency}
              onChange={(e) => setFilterCurrency(e.target.value)}
            >
              <option value="">All</option>
              <option value="USD">USD</option>
              <option value="GBP">GBP</option>
            </select>
          </div>

          <div className="filter-container">
            <label className="filter-label">Filter by Employee Id:</label>
            <select
              value={filterEmployeeId}
              onChange={(e) => setFilterEmployeeId(e.target.value)}
            >
              <option value="">All</option>
              <option value="1000">1000</option>
              <option value="1001">1001</option>
              <option value="1002">1002</option>
              <option value="1003">1003</option>
              <option value="1004">1004</option>
            </select>
          </div>

          <div className="filter-container">
            <label className="filter-label">Filter by Issuer:</label>
            <select
              value={filterIssuerName}
              onChange={(e) => setFilterIssuerName(e.target.value)}
            >
              <option value="">All</option>
              <option value="BNPParibasIssu 4,37% Microsoft Corp (USD)">
                BNPParibasIssu 4,37% Microsoft Corp (USD)
              </option>
              <option value="Airbus 3.15% USD">Airbus 3.15% USD</option>
              <option value="UBS Facebook (USD)">UBS Facebook (USD)</option>
              <option value="Amazon">Amazon</option>
              <option value="HM Treasury United Kingdon">
                HM Treasury United Kingdon
              </option>
              <option value="TEMASEK FINL I LTD GLOBAL MEDIUM TERM NTS BOOK ENTRY REG S">
                TEMASEK FINL I LTD
              </option>
              <option value="First Norway Alpha Kl.IV">
                First Norway Alpha Kl.IV
              </option>
            </select>
          </div>
        </div>
      )}
      <div>
        {filterEmployeeId !== "" ? (
          <React.Fragment>
            Employee with Employee_id : <b>{filterEmployeeId}</b> is responsible
            for Books: <b>{books.join(", ")}</b>
            <br />
            Below you see bonds on present these books only
          </React.Fragment>
        ) : null}
      </div>

      <Row>
        {filteredBonds.map((bond) => (
          <div className="container" key={bond.isin}>
            <BondsDetail info={bond} />
          </div>
        ))}
      </Row>
    </div>
  );
};

export default AllBonds;
