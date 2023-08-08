import React, { useState } from 'react';
import Card from 'react-bootstrap/Card';
import '../BondsDetail.css'; // Import your custom CSS for styling

const BondsDetail = (props) => {
  // Assuming props.info.bondMaturityDate contains the date string "2021-08-04T23:00:00.000+00:00"
  const bondMaturityDate = new Date(props.info.bondMaturityDate);
  const formattedDate = bondMaturityDate.toISOString().split('T')[0];

  const [expanded, setExpanded] = useState(false);

  const handleCardClick = () => {
    setExpanded(!expanded);
  };

  return (
    <div>
      <Card className={`bond-card ${expanded ? 'expanded' : ''}`} onClick={handleCardClick}>
        <Card.Body>
          <Card.Title><strong>ISIN:</strong> {props.info.isin}</Card.Title>
          {!expanded && (
            <Card.Text>
              <strong>Issuer Name:</strong> {props.info.issuerName}<br />
            </Card.Text>
          )}
          {expanded && (
            <Card.Text>
              <strong>Issuer Name:</strong> {props.info.issuerName}<br />
              <strong>Bond Currency:</strong> {props.info.bondCurrency} <br />
              <strong>CUSIP:</strong> {props.info.cusip}<br />
              <strong>Bond Maturity Date:</strong> {formattedDate}<br />
              <strong>Status:</strong> {props.info.status}<br />
              <strong>Type:</strong> {props.info.type}<br />
              <strong>Face Value:</strong> {props.info.faceValue}<br />
            </Card.Text>
          )}
        </Card.Body>
        <div className={`expand-arrow ${expanded ? 'expanded' : ''}`}>
          <span>▼</span>
        </div>
      </Card>
    </div>
  );
};

export default BondsDetail;
