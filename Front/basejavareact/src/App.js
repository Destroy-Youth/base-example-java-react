import React from "react";
import "./App.css";
import * as yup from "yup";
import { NameInputValidation } from "./InputValidation";
import { TextField, Button } from "@material-ui/core";
import { withFormik } from "formik";
import { makeStyles } from "@material-ui/styles";

export default function App() {
  return (
    <div className="App">
      <PersonalDataFormik />
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
    }
  });

  const classes = useStyles();

  return (
    <form
      id={"personalDataForm"}
      className={classes.form}
      onSubmit={handleSubmit}
    >
      <TextField
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
      {errors.inputFirstName && touched.inputFirstName && (
        <div id="feedbackFirstName" className={classes.error}>
          {errors.inputFirstName}
        </div>
      )}
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
  mapPropsToValues({ inputFirstName }) {
    return {
      inputFirstName: inputFirstName || ""
    };
  },
  validationSchema: yup.object().shape({
    inputFirstName: NameInputValidation
  }),
  handleSubmit(values, bag) {
    bag.props.consulta(values.inputFolioRecolecta);
  }
})(PersonalDataForm);
