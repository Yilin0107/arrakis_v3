import { DataGrid } from '@mui/material';
import Checkbox from '@mui/material/Checkbox';
import BondsDetail from './BondsDetail'; // Replace this with the actual path to your BondsDetail component


const Test = ({ filteredBonds }) => {
  // Define the inline styles
  const containerStyle = {
    display: 'flex',
    flexDirection: 'column',
    height: 400, // Adjust the height as per your requirement
  };

  // Rest of your code remains the same...

  return (
    <div sx={containerStyle}>
      <DataGrid
        rows={rows}
        columns={columns}
        checkboxSelection // Enable checkbox selection
        onSelectionModelChange={(newSelection) => {
          // Handle the selection changes here if needed
          console.log(newSelection);
        }}
      />
    </div>
  );
};

export default Test;



