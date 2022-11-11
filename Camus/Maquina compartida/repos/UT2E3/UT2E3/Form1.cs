using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace UT2E3
{
    public partial class Form1 : Form
    {
        private Boolean operado = false;
        Calculadora _calculadora = new Calculadora();
        public Form1()
        {
            InitializeComponent();
        }
        
        private void btnNumero_Click(object sender, EventArgs e)
        {
            if (operado)
            {
                txtTexto.Text = "0";
                operado = false;
            }
            Button button = (Button)sender;
            switch (button.Tag.ToString())
            {
                case "0":
                    if (txtTexto.Text=="0")
                    {
                        txtTexto.Text = "0";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "0";
                    }
                    break;
                case "1":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "1";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "1";
                    }
                    break; ;
                case "2":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "2";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "2";
                    }
                    break;
                case "3":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "3";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "3";
                    }
                    break;
                case "4":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "4";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "4";
                    }
                    break;
                case "5":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "5";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "5";
                    }
                    break;
                case "6":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "6";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "6";
                    }
                    break;
                case "7":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "7";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "7";
                    }
                    break;
                case "8":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "8";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "8";
                    }
                    break;
                case "9":
                    if (txtTexto.Text == "0")
                    {
                        txtTexto.Text = "9";
                    }
                    else
                    {
                        txtTexto.Text = txtTexto.Text + "9";
                    }
                    break;
                case ",":
                    if (txtTexto.Text.Contains(","))
                    {
                        
                    }
                    else
                    {
                        if (txtTexto.Text == "0")
                        {
                            txtTexto.Text = "0,";
                        }
                        else
                        {
                            txtTexto.Text = txtTexto.Text + ",";
                        }
                    }
                    break;
            }

        }

        private void btnOperacion_Click(object sender, EventArgs e)
        {
            Button button = (Button)sender;
            switch (button.Tag.ToString())
            {
                case "/":
                    _calculadora.Vision = float.Parse(txtTexto.Text);
                    _calculadora.Operacion = OperacionEnum.Division;
                    txtTexto.Text = _calculadora.Vision.ToString();
                    break;
                case "*":
                    _calculadora.Vision = float.Parse(txtTexto.Text);
                    _calculadora.Operacion = OperacionEnum.Multiplicacion;
                    txtTexto.Text = _calculadora.Vision.ToString();
                    break;
                case "+":
                    _calculadora.Vision = float.Parse(txtTexto.Text);
                    _calculadora.Operacion = OperacionEnum.Suma;
                    txtTexto.Text = _calculadora.Vision.ToString();
                    break;
                case "-":
                    _calculadora.Vision = float.Parse(txtTexto.Text);
                    _calculadora.Operacion = OperacionEnum.Resta;
                    txtTexto.Text = _calculadora.Vision.ToString();
                    break;

            }
            operado = true;
        }

        private void btnIgual_Click(object sender, EventArgs e)
        {
            _calculadora.Vision = float.Parse(txtTexto.Text);
            _calculadora.Calcular();
            txtTexto.Text=_calculadora.Vision.ToString();
        }

        private void btnC_Click(object sender, EventArgs e)
        {
            txtTexto.Text = "0";
            _calculadora.Borrar();
        }

        private void btnMS_Click(object sender, EventArgs e)
        {
            _calculadora.Memoria= float.Parse(txtTexto.Text);
        }
        private void btnMC_Click(object sender, EventArgs e)
        {
            if (_calculadora.Memoria!=null)
            {
                txtTexto.Text = _calculadora.Memoria.ToString();
            }
        }

        private void Form1_KeyPress(object sender, KeyPressEventArgs e)
        {
            int switchChar = e.KeyChar;
            switch (switchChar)
            {
                case 13:
                    btnIgual.PerformClick();
                    break;
                case 42:
                    btnMultiplicacion.PerformClick();
                    break;
                case 43:
                    btnSuma.PerformClick();
                    break;
                case 44:
                    btnPunto.PerformClick();
                    break;
                case 45:
                    btnResta.PerformClick();
                    break;
                case 47:
                    btnDivision.PerformClick();
                    break;
                case 48:
                    btn0.PerformClick();
                    break;
                case 49:
                    btn1.PerformClick();
                    break;
                case 50:
                    btn2.PerformClick();
                    break;
                case 51:
                    btn3.PerformClick();
                    break;
                case 52:
                    btn4.PerformClick();
                    break;
                case 53:
                    btn5.PerformClick();
                    break;
                case 54:
                    btn6.PerformClick();
                    break;
                case 55:
                    btn7.PerformClick();
                    break;
                case 56:
                    btn8.PerformClick();
                    break;
                case 57:
                    btn9.PerformClick();
                    break;

            }
        }
    }
}
