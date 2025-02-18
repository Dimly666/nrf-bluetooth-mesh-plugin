import { WebPlugin } from '@capacitor/core';

import type {
  BluetoothState,
  NrfMeshPlugin,
  Permissions,
  MeshNetwork,
  ProvisioningCapabilities,
  ProvisioningStatus,
  ScanMeshDevices,
  NodeResetStatus,
  CompositionDataStatus,
  DefaultTTLStatus,
  NetworkTransmitStatus,
} from './definitions';

export class NrfMeshWeb extends WebPlugin implements NrfMeshPlugin {
  async checkPermissions (): Promise<Permissions> {
    console.log('checkPermissions');
    return { LOCATION: 'granted', BLUETOOTH: 'granted' };
  }
  async requestPermissions (): Promise<any> {
    console.log('requestPermissions');
    return;
  }
  async isBluetoothEnabled (): Promise<BluetoothState> {
    console.log('isBluetoothEnabled');
    return { enabled: true };
  }
  async requestBluetoothEnable (): Promise<BluetoothState> {
    console.log('requestBluetoothEnabled');
    return { enabled: true };
  }

  async initMeshNetwork (): Promise<void> {
    console.log('initMeshNetwork');
  }
  async getMeshNetwork (): Promise<MeshNetwork> {
    console.log('getMeshNetwork');
    return {} as MeshNetwork;
  }

  async scanMeshDevices (): Promise<ScanMeshDevices> {
    console.log('scanMeshDevices');
    return { unprovisioned: [], provisioned: [], proxy: [] };
  }
  async getProvisioningCapabilities (): Promise<ProvisioningCapabilities> {
    console.log('getProvisioningCapabilities');
    return {} as ProvisioningCapabilities;
  }
  async provisionDevice (): Promise<ProvisioningStatus> {
    console.log('provisionDevice');
    return { provisioningComplete: true, uuid: '1234' };
  }
  async unprovisionDevice (): Promise<NodeResetStatus> {
    console.log('unprovisionDevice');
    return {} as NodeResetStatus;
  }
  async getCompositionData (): Promise<CompositionDataStatus> {
    console.log('getCompositionData');
    return {} as CompositionDataStatus;
  }
  async getDefaultTTL (): Promise<DefaultTTLStatus> {
    console.log('getDefaultTTL');
    return {} as DefaultTTLStatus;
  }
  async setDefaultTTL (): Promise<DefaultTTLStatus> {
    console.log('setDefaultTTL');
    return {} as DefaultTTLStatus;
  }
  async getNetworkTransmit (): Promise<NetworkTransmitStatus> {
    console.log('getNetworkTransmit');
    return {} as NetworkTransmitStatus;
  }
  async setNetworkTransmit (): Promise<NetworkTransmitStatus> {
    console.log('setNetworkTransmit');
    return {} as NetworkTransmitStatus;
  }

  // async createApplicationKey(): Promise<void> {
  //   console.log('createApplicationKey');
  // }
  // async removeApplicationKey(): Promise<void> {
  //   console.log('removeApplicationKey');
  // }
  // async addApplicationKeyToNode(): Promise<AddAppKeyStatus> {
  //   console.log('addApplicationKeyToNode');
  //   return { success: true };
  // }
  // async bindApplicationKeyToModel(): Promise<void> {
  //   console.log('bindApplicationKeyToModel');
  // }
  // async sendGenericOnOffSet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendGenericOnOffSet');
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // async sendGenericOnOffGet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendGenericOnOffSet');
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // async sendGenericPowerLevelSet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendGenericPowerLevelSet');
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // async sendGenericPowerLevelGet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendGenericPowerLevelGet');
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // async sendLightHslSet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendLightHslSet');
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // async sendLightHslGet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendLightHslGet');
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // initMeshNetwork(): Promise<MeshNetworkObject> {
  //   return Promise.resolve({ meshNetwork: 'meshNetwork' });
  // }
  // async exportMeshNetwork(): Promise<MeshNetworkObject> {
  //   console.log('exportMeshNetwork');
  //   return { meshNetwork: 'meshNetwork' };
  // }
  // async importMeshNetwork(): Promise<void> {
  //   console.log('importMeshNetwork');
  // }
  // async sendVendorModelMessage(options: {
  //   unicastAddress: number;
  //   appKeyIndex: number;
  //   modelId: number;
  //   companyIdentifier: number;
  //   opcode: number;
  //   payload: Uint8Array;
  // }): Promise<ModelMessageStatus | PluginCallRejection> {
  //   console.log('sendVendorModelMessage', options);
  //   return { src: 1, dst: 2, opcode: 3, data: {} };
  // }
  // sendLightCtlSet(): Promise<ModelMessageStatus | PluginCallRejection> {
  //   throw new Error('Method not implemented.');
  // }
}
