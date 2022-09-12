import React from "react";
import './Search.css';

function Search() {
    return (
        <form>
            <label className="searchLabel">
                Search for item:
                <input type="text"/>
            </label>
        </form>
    )
}

export default Search;