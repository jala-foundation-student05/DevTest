import { Button, Container, Grid, TextField, Typography } from '@material-ui/core';
import React, { useEffect, useState } from 'react';
//Components
import Table from './Table'

//Services
import usersService from '../services/users/usersService';

function HomePage () {

    //States variables
    const [users, setUsers] = useState();
    const [usersFiltered, setUsersFiltered] = useState();
    const [page, setPages] = useState();
    const [search, setSearch] = useState("");
    
    useEffect(() => {
        setPages(1);
        usersService
        .getUsers(1,10,'abc')
        .then((response) => {
            let usersResponse = []
            for (const user of response.data.results) {
                let us = {...user}
                us.id = user.login.uuid
                usersResponse.push(us)
            }
            setUsers(usersResponse);
            setUsersFiltered(usersResponse);
        })
        .catch((e) => {
            console.log(e);
        });
    }, []);
    
    return (
        <Container>

            <Typography variant="h1" component="h2" style={{margin: '1rem'}}>
                Contacts App
            </Typography>

            <Grid container alignItems="center">
                <Grid item xs={2}/>
                <Grid item xs={4}>
                    <TextField 
                        id="search-field"
                        label="Search..."
                        variant="outlined" 
                        style={{margin: '1rem'}}
                        value={search}
                        onChange={(event) => {
                          setSearch(event.target.value);
                        }}
                    />
                </Grid>
                <Grid item xs={4}>
                    <Button variant="contained" color="primary" onClick={() => 
                        setUsersFiltered(users.filter((user) => user.login.username.includes(search)))
                        }
                    >
                        Search
                    </Button>
                </Grid>
            </Grid>

            <Table data={usersFiltered} page={page}/>
            
        </Container>
    )
}

export default HomePage;