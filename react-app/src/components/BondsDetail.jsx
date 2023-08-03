import React from 'react';
import Card from 'react-bootstrap/Card'

const BondsDetail = (props) => {

  return (
    <div>
      <Card>
        <Card.Body>
      <Card.Title><strong>ISIN:</strong> {props.info.isin}</Card.Title>
      <Card.Text>
      <p><strong>Bond Currency:</strong> {props.info.currency}</p> 
      <p><strong>CUSIP:</strong> {props.info.cusip} </p>
      <p><strong>Issuer Name:</strong> {props.info.issuerName} </p>
      <p><strong>Bond Maturity Date:</strong> {props.info.maturityDate} </p>
      <p><strong>Status:</strong> {props.info.status} </p>
      <p><strong>Type:</strong> {props.info.type}</p>
  
      </Card.Text>
     </Card.Body>
      </Card>
    </div>
  );
};

export default BondsDetail;
