import React, { useState } from "react";
import "./pages/app/App.css";
import * as yup from "yup";
import { NameInputValidation, StringInputValidation } from "./InputValidation";
import { TextField, Button } from "@material-ui/core";
import { withFormik } from "formik";
import { makeStyles } from "@material-ui/styles";
import Radio from "@material-ui/core/Radio";
import RadioGroup from "@material-ui/core/RadioGroup";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import FormControl from "@material-ui/core/FormControl";
import FormLabel from "@material-ui/core/FormLabel";
import { savePersonData } from "./service";
import CircularProgress from "@material-ui/core/CircularProgress";

export default function Register() {
    const [isLoading, setIsLoading] = useState(false);

    return (
        <div className="App">
            <PersonalDataFormik setIsLoading={setIsLoading} />
            {isLoading ? <CircularProgress /> : null}
        </div>
    );
}

const PersonalDataForm = ({
    values,
    touched,
    errors,
    handleChange,
    handleBlur,
    handleSubmit
}) => {
    /**
     * Material-UI Styles hook API
     */
    const useStyles = makeStyles({
        error: {
            color: "red"
        },
        form: {
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            marginTop: "2rem"
        },
        input: {
            margin: "0 0 1rem 0"
        },
        buttonGroup: {
            display: "flex",
            alignItems: "center",
            flexDirection: "row",
            "& button:first-child": {
                marginRight: "2rem"
            }
        },
        radioGroup: {
            display: "fles",
            flexDirection: "row"
        }
    });

    /**
     * Custom Material UI style hook
     */
    const classes = useStyles();

    return (
        <form
            id={"personalDataForm"}
            className={classes.form}
            onSubmit={handleSubmit}
        >
            {errors.inputFirstName && touched.inputFirstName && (
                <div id="feedbackFirstName" className={classes.error}>
                    {errors.inputFirstName}
                </div>
            )}
            <TextField
                required
                className={classes.input}
                autoComplete="off"
                type={"text"}
                id={"inputFirstName"}
                value={values.inputFirstName}
                onChange={handleChange}
                variant={"outlined"}
                label={"Nombre"}
                margin={"normal"}
                autoFocus={true}
            />
            {errors.inputLastName && touched.inputLastName && (
                <div id="feedbackLastName" className={classes.error}>
                    {errors.inputLastName}
                </div>
            )}
            <TextField
                required
                className={classes.input}
                autoComplete="off"
                type={"text"}
                id={"inputLastName"}
                value={values.inputLastName}
                onChange={handleChange}
                variant={"outlined"}
                label={"Apellido"}
                margin={"normal"}
            />
            {errors.inputMail && touched.inputMail && (
                <div id="feedbackMail" className={classes.error}>
                    {errors.inputMail}
                </div>
            )}
            <TextField
                required
                className={classes.input}
                autoComplete="off"
                type={"email"}
                id={"inputMail"}
                value={values.inputMail}
                onChange={handleChange}
                variant={"outlined"}
                label={"Correo"}
                margin={"normal"}
            />

            <FormControl required={true}>
                <FormLabel>Sexo</FormLabel>
                <RadioGroup
                    name="gender"
                    value={values.radioGender}
                    onChange={handleChange}
                    className={classes.radioGroup}
                >
                    <FormControlLabel value="F" control={<Radio />} label="Female" />
                    <FormControlLabel value="M" control={<Radio />} label="Male" />
                </RadioGroup>
            </FormControl>

            <TextField
                id="birthDate"
                required
                label="Fecha de nacimiento"
                type="date"
                className={classes.input}
                InputLabelProps={{
                    shrink: true
                }}
                value={values.dateBirthDate}
                onChange={handleChange}
            />

            <div className={classes.buttonGroup}>
                <Button variant={"outlined"} color={"secondary"}>
                    Limpiar
        </Button>
                <Button type={"submit"} variant={"outlined"} color={"primary"}>
                    Enviar
        </Button>
            </div>
        </form>
    );
};

const PersonalDataFormik = withFormik({
    mapPropsToValues() {
        return {
            inputFirstName: "",
            inputLastName: "",
            inputMail: ""
        };
    },
    validationSchema: yup.object().shape({
        inputFirstName: NameInputValidation,
        inputLastName: NameInputValidation,
        inputMail: StringInputValidation
    }),
    handleSubmit(values, bag) {
        console.log(values);

        savePersonData(
            values.inputFirstName,
            values.inputLastName,
            values.inputMail,
            values.gender,
            values.birthDate,
            [], //FIXME ingresar hobbies
            bag.props.setIsLoading
        );
    },
    displayName: "PersonalDataForm"
})(PersonalDataForm);
