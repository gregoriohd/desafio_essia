<template>
    <ul>
      <li v-for="subdir in subdiretorios" :key="subdir.id">
        <strong>{{ subdir.nome }}</strong>
        <ul>
          <li v-for="arquivo in subdir.arquivos" :key="arquivo.id">
            {{ arquivo.nome }} ({{ arquivo.tipo }})
          </li>
        </ul>
        <!-- Recursão para subdiretórios aninhados -->
        <sub-diretorio v-if="subdir.subdiretorios" :subdiretorios="subdir.subdiretorios" />
      </li>
    </ul>
  </template>
  
  <script>
  import { defineComponent } from 'vue';
  
  export default defineComponent({
    name: "SubDiretorio",
    props: {
      subdiretorios: {
        type: Array,
        required: true,
      },
    },
  });
  </script>
  