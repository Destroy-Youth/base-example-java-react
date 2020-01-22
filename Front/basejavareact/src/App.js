import React from "react";
import "./App.css";
import * as yup from "yup";
import { NameInputValidation } from "./InputValidation";
import { TextField } from "@material-ui/core";
import { withFormik } from "formik";

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
  return (
    <form id={"personalDataForm"} onSubmit={handleSubmit}>
      <TextField
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
        <div id="feedbackFirstName">{errors.inputFirstName}</div>
      )}
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
