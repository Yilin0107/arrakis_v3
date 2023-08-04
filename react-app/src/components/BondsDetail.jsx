import React from 'react';
import Card from 'react-bootstrap/Card';

const BondsDetail = (props) => {
  // Assuming props.info.bondMaturityDate contains the date string "2021-08-04T23:00:00.000+00:00"
  const bondMaturityDate = new Date(props.info.bondMaturityDate);
  const formattedDate = bondMaturityDate.toISOString().split('T')[0];

  return (
    <div>
      <Card>
        <Card.Body>
          <Card.Title><strong>ISIN:</strong> {props.info.isin}</Card.Title>
          <Card.Text>
            <strong>Bond Currency:</strong> {props.info.bondCurrency} <br />
            <strong>CUSIP:</strong> {props.info.cusip}<br />
            <strong>Issuer Name:</strong> {props.info.issuerName}<br />
            <strong>Bond Maturity Date:</strong> {formattedDate}<br />
            <strong>Status:</strong> {props.info.status}<br />
            <strong>Type:</strong> {props.info.type}<br />
            <strong>Face Value:</strong> {props.info.faceValue}<br />
            <strong>Employee Id:</strong> {props.info.employeeId}<br />
          </Card.Text>
        </Card.Body>
      </Card>
    </div>
  );
};

export default BondsDetail;