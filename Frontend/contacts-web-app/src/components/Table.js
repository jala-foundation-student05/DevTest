import React from 'react';
import { DataGrid } from '@material-ui/data-grid';

const columns = [
  {
    field: 'username',
    headerName: 'Username',
    width: 180,
    valueGetter: (params) =>
      `${params.getValue(params.id, 'login').username}`,
  },
  {
    field: 'first',
    headerName: 'First name',
    width: 150,
    valueGetter: (params) =>
      `${params.row.name.first}`,
  },
  {
    field: 'last',
    headerName: 'Last name',
    width: 150,
    valueGetter: (params) =>
      `${params.row.name.last}`,
  },
  {
    field: 'email',
    headerName: 'Email',
    width: 250,
  },
  {
    field: 'location',
    headerName: 'Location',
    width: 250,
    valueGetter: (params) =>
      `${params.row.location.city || ''} ${params.row.location.city && params.row.location.country ? ', ' : ''} ${
        params.row.location.country || ''
      }`,
  },
];

const rows = [
  { id: 1, name : {last: 'Snow', first: 'Jon'}, age: 35, login:{ login:{ username: 'example'}}, email: 'example@example.com', location: {city: 'Lima', country: 'Peru'}},
  { id: 2, name: {last: 'Lannister', first: 'Cersei'}, age: 42, login:{ username: 'example'}, email: 'example@example.com', location: {country: 'Spain'} },
  { id: 3, name:{last: 'Lannister', first: 'Jaime'}, age: 45, login:{ username: 'example'}, email: 'example@example.com', location: {city: 'Lima'} },
  { id: 4, name:{last: 'Stark', first: 'Arya'}, age: 16, login:{ username: 'example'}, email: 'example@example.com', location: {city: 'Lima'} },
];

export default function DataTable(props) {

    return (
        <div style={{ height: 700, width: '100%' }}>
        <DataGrid
            rows={props.data && props.data !==undefined ? props.data : rows}
            columns={columns}
            pageSize={15}
            disableSelectionOnClick
        />
        </div>
    );
}