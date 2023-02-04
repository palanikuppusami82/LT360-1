import { Component, OnInit } from '@angular/core';

import { ViewChild } from "@angular/core";
import { Router } from '@angular/router';
import { ApexAxisChartSeries,
  ChartComponent,
  ApexDataLabels,
  ApexPlotOptions,
  ApexYAxis,
  ApexAnnotations,
  ApexFill,
  ApexStroke,
  ApexGrid } from "ng-apexcharts";

import {
  ApexNonAxisChartSeries,
  ApexResponsive,
  ApexChart
} from "ng-apexcharts";

export type OrganizationChartOptions = {
  series: ApexNonAxisChartSeries;
  chart: ApexChart;
  responsive: ApexResponsive[];
  labels: any;
};

export type AssetChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  dataLabels: ApexDataLabels;
  plotOptions: ApexPlotOptions;
  yaxis: ApexYAxis;
  xaxis: any; //ApexXAxis;
  annotations: ApexAnnotations;
  fill: ApexFill;
  stroke: ApexStroke;
  grid: ApexGrid;
};

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  @ViewChild("chart") chart: ChartComponent | undefined;
  public organizationChartOptions: Partial<OrganizationChartOptions>;
  public assetChartOptions: Partial<AssetChartOptions>;
  router: string;
  public showDashboardComponent : boolean

  constructor(private _router: Router) {
    this.showDashboardComponent=true;
    this.router = _router.url; 
    this.organizationChartOptions = {
      series: [44, 55, 100, 43, 22],
      chart: {
        type: "donut"
      },
      labels: ["NTT DATA", "BOSCH", "SAP", "RAM TOOLS", "Other"],
      responsive: [
        {
          breakpoint: 480,
          options: {
            chart: {
              width: 200
            },
            legend: {
              position: "bottom"
            }
          }
        }
      ]
    };

    this.assetChartOptions = {
      series: [
        {
          name: "Count",
          data: [44, 55, 41, 67, 22, 43, 21]
        }
      ],
      chart: {
        height: 350,
        type: "bar"
      },
      plotOptions: {
        bar: {
          columnWidth: "50%",
        }
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 2
      },

      grid: {
        row: {
          colors: ["#fff", "#f2f2f2"]
        }
      },
      xaxis: {
        labels: {
          rotate: -45
        },
        categories: [
          "Laptops",
          "Monitor",
          "Mouse",
          "Keyboard",
          "Dongle",
          "Headphones",
          "Wifi-Modem"
        ],
        tickPlacement: "on"
      },
      yaxis: {
        title: {
          text: "Asset Count"
        }
      },
      fill: {
        type: "gradient",
        gradient: {
          shade: "light",
          type: "horizontal",
          shadeIntensity: 0.25,
          gradientToColors: undefined,
          inverseColors: true,
          opacityFrom: 0.85,
          opacityTo: 0.85,
          stops: [50, 0, 100]
        }
      }
    };


  }

  ngOnInit(): void {
  }

  


  
}