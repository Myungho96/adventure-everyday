package com.ssafy.antenna.domain.antenna.dto;

public record DetailAntennaRes(
		Long antennaId,
		Long area,
		double lng,
		double lat,
		String w3w,
		String nearestPlace
) {
}
