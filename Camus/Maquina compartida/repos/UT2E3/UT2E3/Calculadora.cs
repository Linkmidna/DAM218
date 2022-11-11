using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UT2E3
{
    
    internal class Calculadora
    {
        private float _cache=0;
        private float _visor=0;
        private OperacionEnum _operacion;
        public float? Memoria { get; set; }
        public OperacionEnum Operacion {
            get
            {
                return _operacion;
            }
            set
            {
                if (_operacion==OperacionEnum.SinOperacion)
                {
                    _cache = _visor;
                }
                else
                {   
                    _cache = _visor;
                    Calcular();
                }
                _operacion = value;
            }
         }
        public float Vision
        {
            get
            {
                return _visor;
            }
            set
            {
                if(_visor!=0){
                    _cache = _visor;
                }
                _visor = value;
            }
        }
        public void Calcular()
        {
            switch (_operacion)
            {
                case OperacionEnum.SinOperacion:
                    break;

                case OperacionEnum.Suma:
                    _visor = _cache + _visor;
                    break;

                case OperacionEnum.Resta:
                    _visor = _cache -_visor;
                    break;

                case OperacionEnum.Multiplicacion:
                    _visor = _cache * _visor;
                    break;

                case OperacionEnum.Division:
                    _visor = _cache / _visor;
                    break;
            }
            _operacion = OperacionEnum.SinOperacion;
        }
        public void Borrar()
        {
            _operacion = OperacionEnum.SinOperacion;
            _cache=0;
        }
    }
}
