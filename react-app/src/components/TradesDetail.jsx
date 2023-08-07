import React, { useState } from 'react';
import Card from 'react-bootstrap/Card';
import '../TradesDetail.css'; // Import your custom CSS for styling

const TradesDetail = (props) => {
  // Assuming props.info.bondMaturityDate contains the date string "2021-08-04T23:00:00.000+00:00"
   const tradeDate = new Date(props.info.tradeDate);
   const formattedTradeDate = tradeDate.toISOString().split('T')[0];

    const tradeSettlementDate = new Date(props.info.tradeSettlementDate);
    const formattedTradeSettlementDate = tradeSettlementDate.toISOString().split('T')[0];

  const [expanded, setExpanded] = useState(false);

  const handleCardClick = () => {
    setExpanded(!expanded);
  };

  return (
    <div>
      <Card className={`trade-card ${expanded ? 'expanded' : ''}`} onClick={handleCardClick}>
        <Card.Body>
          <Card.Title><strong>ISIN:</strong> {props.info.isin}</Card.Title>
          {!expanded && (
            <Card.Text>
              <strong>Trade Id:</strong> {props.info.trade_id}<br />
              <strong>Bond Holder:</strong> {props.info.bondHolder}<br />
              <strong>Trade Date:</strong> {formattedTradeDate}<br />
              <strong>Trade Type:</strong> {props.info.tradeType}<br />
            </Card.Text>
          )}
          {expanded && (
            <Card.Text>
              <strong>Trade Id:</strong> {props.info.trade_id}<br />
              <strong>Bond Holder:</strong> {props.info.bondHolder}<br />
              <strong>Trade Date:</strong> {formattedTradeDate}<br />
              <strong>Trade Type:</strong> {props.info.tradeType}<br />
              <strong>Trade Settlement Date:</strong> {formattedTradeSettlementDate}<br />
              <strong>Trade Status:</strong> {props.info.tradeStatus}<br />
              <strong>Trade Currency:</strong> {props.info.tradeCurrency}<br />
              <strong>Trade Quantity:</strong> {props.info.quantity}<br />
              <strong>Unit Price:</strong> {props.info.unitPrice}<br />
              <strong>Coupon Percent:</strong> {props.info.couponPercent}<br />
              <strong>Book Name:</strong> {props.info.bookName}<br />

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

export default TradesDetail;
