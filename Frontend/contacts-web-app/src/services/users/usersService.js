import axios from "axios";
import * as API from "../serverApi";

const API_URL = API.API_URL_ORIGIN;

const getUsers = (page, size, seed) => {
    return axios.get(
        API_URL + "?page=" + page + "&results=" + size + "&seed=" + seed,
        {}
    );
};

export default {
    getUsers,
};