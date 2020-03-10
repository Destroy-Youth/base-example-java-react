import React from 'react'
import { makeStyles } from "@material-ui/styles";
import { Input, FormControl, Button } from '@material-ui/core'
import { useInput } from '../../hooks/input'

const Loggin = () => {

    const useStyles = makeStyles({
        error: {
            color: "red"
        },
        form: {
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            marginTop: "2rem"
        }
    })

    const classes = useStyles()

    const username = useInput('');
    const password = useInput('');

    const loggin = (e) => {
        e.preventDefault()
    }


    return (
        <div>
            <form onSubmit={loggin} className={classes.form}>
                <FormControl>
                    <Input id="username" {...username} />
                </FormControl>
                <FormControl>
                    <Input id="password" {...password} />
                </FormControl>
                <Button type="submit">Log in</Button>
                <div class="g-signin2" data-onsuccess="onSignIn"></div>

            </form>
        </div>
    )
}

export default Loggin
