# Sistema de Monitoreo Docente Web 🖥️📡  
**Plataforma para verificación de asistencia docente**  

![uam logo ](https://github.com/user-attachments/assets/3a32a53e-359e-4613-9fe4-f0f0727c586d)


Sistema web desarrollado en **OpenXava** que centraliza los reportes de asistencia docente recibidos. permitiendo registrar y analizar el cumplimiento horario de profesores en aulas universitarias.  

## 🔍 Contexto Actual  
Proceso manual vigente:  
- Personal de apoyo recorre aulas y reporta por walkie-talkie.  
- Sala de docentes registra manualmente en planillas.  

## ✨ Solución Propuesta  
- **Interfaz web** para registrar reportes recibidos por walkie-talkie.  
- **Base de datos centralizada** con:  
  - ✅ Estado del profesor (*Presente/Ausente/Retrasado*).  
  - ⏱ Hora real de llegada.  
  - 📍 Aula/edificio.  
- **Dashboard administrativo** con métricas de cumplimiento.  

## 🛠️ Stack Tecnológico  
| Capa           | Tecnología               |  
|----------------|--------------------------|  
| **Backend**    | OpenXava 9.0 (Java 11+)  |  
| **Base de Datos** | PostgreSQL 14 / MySQL 8  |  

## 🖥️ Módulos Principales  
1. **Registro de Reportes**  
   - Formulario para ingresar datos recibidos por radio.  
2. **Consulta de Estado**  
   - Búsqueda por profesor, aula o fecha.  

## 🚀 Instalación (Local)  
1. Requisitos:  
   ```bash  
   Java JDK 11+, OpenXava 9+, PostgreSQL 14+  
   git clone https://github.com/Catwithstyle/ProyectoObjetos.git
