<template>
  <div id="app">
    <ul>
      <li v-for="diretorio in diretorios" :key="diretorio.id">
        <strong>{{ diretorio.nome }}</strong>
        <ul>
          <li v-for="arquivo in diretorio.arquivos" :key="arquivo.id">
            {{ arquivo.nome }} ({{ arquivo.tipo }})
          </li>
        </ul>
        <sub-diretorio :subdiretorios="diretorio.subdiretorios" />
      </li>
    </ul>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import SubDiretorio from './SubDiretorio.vue'; // Importando o componente SubDiretorio

export default {
  name: 'App',
  components: {
    SubDiretorio,
  },
  setup() {
    const diretorios = ref([]);

    const fetchDiretorios = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/diretorios');
        const data = await response.json();
        diretorios.value = data;
      } catch (error) {
        console.error(error);
      }
    };

    onMounted(() => {
      fetchDiretorios();
    });

    return {
      diretorios,
    };
  },
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
 
  color: #2c3e50;
  margin-top: 60px;
 
}

ul {
  list-style-type: none; /* Remove os bullets */
  margin-left: 30px; /* Cria indentação para subníveis */
  padding: 0;
}

li {
  margin: 5px 0;
}

li strong {
  cursor: pointer;
  color: #2c3e50; /* Cor das pastas */
}

li strong::before {
  content: '📂'; /* Ícone de pasta */
  margin-right: 5px;
}

li:not(.diretorio) {
  color: #34495e; /* Cor dos arquivos */
}

li:not(.diretorio)::before {
 /* content: '📄'; /* Ícone de arquivo */
  margin-right: 5px;
}

/* Ao passar o mouse sobre os diretórios */
li strong:hover {
  text-decoration: underline;
  color: #2980b9;
}

/* Estilo de subdiretórios */
.sub-diretorio {
  margin-left: 20px; /* Maior indentação para subdiretórios */
}

</style>
